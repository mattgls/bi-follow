package com.mgui.bifollow

data class TariffItem(
    val name: String,
    val price: Double,
    val category: String,
    val service: String
)

object TariffDataSource {
    val noveaTariffs = listOf(
        // VÉLO
        TariffItem("Vélo Normal", 3.60, "VÉLO", "Service Novéa"),
        TariffItem("Vélo Prio", 7.20, "VÉLO", "Service Novéa"),
        TariffItem("Vélo Vip", 12.96, "VÉLO", "Service Novéa"),
        TariffItem("Vélo Normal Zone2", 5.76, "VÉLO", "Service Novéa"),
        TariffItem("Vélo Prio Zone2", 8.64, "VÉLO", "Service Novéa"),
        TariffItem("Vélo Vip Zone2", 14.40, "VÉLO", "Service Novéa"),
        
        // CARGO
        TariffItem("Cargo Normal", 8.40, "CARGO", "Service Novéa"),
        TariffItem("Cargo Prio", 14.40, "CARGO", "Service Novéa"),
        TariffItem("Cargo Vip", 23.50, "CARGO", "Service Novéa"),
        TariffItem("Cargo Normal Zone2", 9.60, "CARGO", "Service Novéa"),
        TariffItem("Cargo Prio Zone2", 15.84, "CARGO", "Service Novéa"),
        TariffItem("Cargo Vip Zone2", 25.00, "CARGO", "Service Novéa"),
        
        // NAVETTE
        TariffItem("Navette Vélo", 3.60, "NAVETTE", "Service Novéa"),
        TariffItem("Navette Cargo", 8.40, "NAVETTE", "Service Novéa"),
        TariffItem("Navette RATP", 6.00, "NAVETTE", "Service Novéa"),
        
        // A3
        TariffItem("-3KG A3 Normal", 5.76, "A3", "Service Novéa"),
        
        // AUTRE
        TariffItem("Attente (15 min)", 4.00, "AUTRE", "Service Novéa")
    )

    val pionniersTariffs = listOf(
        // VÉLO
        TariffItem("Vélo Normal", 3.60, "VÉLO", "Service Pionniers"),
        TariffItem("Vélo Prio", 7.20, "VÉLO", "Service Pionniers"),
        TariffItem("Vélo Vip", 12.96, "VÉLO", "Service Pionniers"),
        TariffItem("Vélo Prio Zone2", 12.00, "VÉLO", "Service Pionniers"),
        TariffItem("Vélo Vip Zone2", 24.00, "VÉLO", "Service Pionniers"),
        
        // CARGO
        TariffItem("Cargo Normal", 8.40, "CARGO", "Service Pionniers"),
        TariffItem("Cargo Prio", 14.40, "CARGO", "Service Pionniers"),
        TariffItem("Cargo Vip", 23.50, "CARGO", "Service Pionniers"),
        TariffItem("Cargo Prio Zone2", 24.00, "CARGO", "Service Pionniers"),
        TariffItem("Cargo Vip Zone2", 45.00, "CARGO", "Service Pionniers"),
        
        // GME
        TariffItem("GME", 6.48, "GME", "Service Pionniers"),
        TariffItem("GME 400+", 12.00, "GME", "Service Pionniers"),
        TariffItem("GME Zone2", 7.20, "GME", "Service Pionniers"),
        
        // AUTRE
        TariffItem("Attente (15 min)", 4.00, "AUTRE", "Service Pionniers")
    )
    
    val allTariffs = noveaTariffs + pionniersTariffs
}
