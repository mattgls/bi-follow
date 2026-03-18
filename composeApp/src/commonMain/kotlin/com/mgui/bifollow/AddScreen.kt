package com.mgui.bifollow

import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.waitForUpOrCancellation
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.unit.dp
import bifollow.composeapp.generated.resources.Res
import bifollow.composeapp.generated.resources.cancel
import bifollow.composeapp.generated.resources.calendar_desc
import bifollow.composeapp.generated.resources.date_placeholder
import bifollow.composeapp.generated.resources.ok
import bifollow.composeapp.generated.resources.select_date
import org.jetbrains.compose.resources.stringResource

@Composable
fun AddScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        DatePickerFieldToModal()
    }
}

@Composable
fun DatePickerFieldToModal(modifier: Modifier = Modifier) {
    var selectedDateMillis by remember { mutableStateOf<Long?>(null) }
    var showModal by remember { mutableStateOf(false) }

    // On affiche la date formatée ou un texte vide
    val dateText = selectedDateMillis?.let { convertMillisToDate(it) } ?: ""

    OutlinedTextField(
        value = dateText,
        onValueChange = { },
        label = { Text(stringResource(Res.string.select_date)) },
        placeholder = { Text(stringResource(Res.string.date_placeholder)) },
        trailingIcon = {
            Icon(Icons.Default.DateRange, contentDescription = stringResource(Res.string.calendar_desc))
        },
        readOnly = true, // Empêche l'ouverture du clavier
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

// TODO Fonction à implémenter dans androidMain avec SimpleDateFormat
expect fun convertMillisToDate(millis: Long): String
