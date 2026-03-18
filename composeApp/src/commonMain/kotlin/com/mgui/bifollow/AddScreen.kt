package com.mgui.bifollow

import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.waitForUpOrCancellation
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuAnchorType
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerEventPass
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import bifollow.composeapp.generated.resources.Res
import bifollow.composeapp.generated.resources.calendar_desc
import bifollow.composeapp.generated.resources.cancel
import bifollow.composeapp.generated.resources.client
import bifollow.composeapp.generated.resources.date_placeholder
import bifollow.composeapp.generated.resources.ok
import bifollow.composeapp.generated.resources.select_date
import org.jetbrains.compose.resources.stringResource

@Composable
@Preview
fun AddScreenPreview() {
    BiFollowTheme {
        AddScreen()
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddScreen() {
    val noveaJobs = TariffDataSource.noveaJobs
    val pionniersJobs = TariffDataSource.pionniersJobs

    var expanded by remember { mutableStateOf(false) }
    var selectedJob by remember { mutableStateOf<JobItem?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Ajouter un job",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        DatePickerFieldToModal()

        Spacer(modifier = Modifier.height(24.dp))

        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = it },
            modifier = Modifier.fillMaxWidth()
        ) {
            OutlinedTextField(
                value = selectedJob?.let { "${it.name} (${it.price}€)" } ?: "",
                onValueChange = {},
                readOnly = true,
                label = { Text("Sélectionner un tarif") },
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                colors = ExposedDropdownMenuDefaults.outlinedTextFieldColors(),
                modifier = Modifier
                    .menuAnchor(
                        type = ExposedDropdownMenuAnchorType.PrimaryNotEditable,
                        enabled = true
                    )
                    .fillMaxWidth()
            )

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                // Section Novea
                DropdownHeader("— Service Novéa —")
                noveaJobs.groupBy { it.category }.forEach { (category, jobs) ->
                    DropdownSubHeader(category)
                    jobs.forEach { job ->
                        JobDropdownItem(job) {
                            selectedJob = job
                            expanded = false
                        }
                    }
                }

                HorizontalDivider(modifier = Modifier.padding(vertical = 4.dp))

                // Section Pionniers
                DropdownHeader("— Service Pionniers —")
                pionniersJobs.groupBy { it.category }.forEach { (category, jobs) ->
                    DropdownSubHeader(category)
                    jobs.forEach { job ->
                        JobDropdownItem(job) {
                            selectedJob = job
                            expanded = false
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            state = rememberTextFieldState(),
            label = { Text(stringResource(Res.string.client)) },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = { /* TODO Add the job to the selected date */ },
            modifier = Modifier.fillMaxWidth(),
            enabled = selectedJob != null
        ) {
            val buttonText =
                if (selectedJob != null) "Ajouter (${selectedJob!!.price}€)" else "Ajouter"
            Text(buttonText)
        }
    }
}

@Composable
private fun DropdownHeader(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.titleMedium,
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        textAlign = TextAlign.Center
    )
}

@Composable
private fun DropdownSubHeader(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.labelLarge,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.secondary,
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun JobDropdownItem(job: JobItem, onClick: () -> Unit) {
    DropdownMenuItem(
        text = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = job.name,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = "${job.price} €",
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        },
        onClick = onClick,
        contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
    )
}

@Composable
fun DatePickerFieldToModal(modifier: Modifier = Modifier) {
    var selectedDateMillis by remember { mutableStateOf<Long?>(null) }
    var showModal by remember { mutableStateOf(false) }

    val dateText = selectedDateMillis?.let { convertMillisToDate(it) } ?: ""

    OutlinedTextField(
        value = dateText,
        onValueChange = { },
        label = { Text(stringResource(Res.string.select_date)) },
        placeholder = { Text(stringResource(Res.string.date_placeholder)) },
        trailingIcon = {
            Icon(
                Icons.Default.DateRange,
                contentDescription = stringResource(Res.string.calendar_desc)
            )
        },
        readOnly = true,
        modifier = modifier
            .fillMaxWidth()
            .pointerInput(Unit) {
                awaitEachGesture {
                    awaitFirstDown(pass = PointerEventPass.Initial)
                    val upEvent = waitForUpOrCancellation(pass = PointerEventPass.Initial)
                    if (upEvent != null) {
                        showModal = true
                    }
                }
            }
    )

    if (showModal) {
        DatePickerModal(
            onDateSelected = { selectedDateMillis = it },
            onDismiss = { showModal = false }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerModal(
    onDateSelected: (Long?) -> Unit,
    onDismiss: () -> Unit
) {
    val datePickerState = rememberDatePickerState()

    DatePickerDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            TextButton(onClick = {
                onDateSelected(datePickerState.selectedDateMillis)
                onDismiss()
            }) {
                Text(stringResource(Res.string.ok))
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text(stringResource(Res.string.cancel))
            }
        }
    ) {
        DatePicker(state = datePickerState)
    }
}

expect fun convertMillisToDate(millis: Long): String
