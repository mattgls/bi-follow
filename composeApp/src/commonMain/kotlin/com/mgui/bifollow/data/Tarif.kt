package com.mgui.bifollow.data

data class JobItem(
    val name: String,
    val price: Double,
    val category: String,
    val service: String
)

object TariffDataSource {
    val noveaJobs = listOf(
        // VÉLO
        JobItem("Vélo Normal", 3.60, "VÉLO", "Service Novéa"),
        JobItem("Vélo Prio", 7.20, "VÉLO", "Service Novéa"),
        JobItem("Vélo Vip", 12.96, "VÉLO", "Service Novéa"),
        JobItem("Vélo Normal Zone2", 5.76, "VÉLO", "Service Novéa"),
        JobItem("Vélo Prio Zone2", 8.64, "VÉLO", "Service Novéa"),
        JobItem("Vélo Vip Zone2", 14.40, "VÉLO", "Service Novéa"),
        
        // CARGO
        JobItem("Cargo Normal", 8.40, "CARGO", "Service Novéa"),
        JobItem("Cargo Prio", 14.40, "CARGO", "Service Novéa"),
        JobItem("Cargo Vip", 23.50, "CARGO", "Service Novéa"),
        JobItem("Cargo Normal Zone2", 9.60, "CARGO", "Service Novéa"),
        JobItem("Cargo Prio Zone2", 15.84, "CARGO", "Service Novéa"),
        JobItem("Cargo Vip Zone2", 25.00, "CARGO", "Service Novéa"),
        
        // NAVETTE
        JobItem("Navette Vélo", 3.60, "NAVETTE", "Service Novéa"),
        JobItem("Navette Cargo", 8.40, "NAVETTE", "Service Novéa"),
        JobItem("Navette RATP", 6.00, "NAVETTE", "Service Novéa"),
        
        // A3
        JobItem("-3KG A3 Normal", 5.76, "A3", "Service Novéa"),
        
        // AUTRE
        JobItem("Attente (15 min)", 4.00, "AUTRE", "Service Novéa")
    )

    val pionniersJobs = listOf(
        // VÉLO
        JobItem("Vélo Normal", 3.60, "VÉLO", "Service Pionniers"),
        JobItem("Vélo Prio", 7.20, "VÉLO", "Service Pionniers"),
        JobItem("Vélo Vip", 12.96, "VÉLO", "Service Pionniers"),
        JobItem("Vélo Prio Zone2", 12.00, "VÉLO", "Service Pionniers"),
        JobItem("Vélo Vip Zone2", 24.00, "VÉLO", "Service Pionniers"),
        
        // CARGO
        JobItem("Cargo Normal", 8.40, "CARGO", "Service Pionniers"),
        JobItem("Cargo Prio", 14.40, "CARGO", "Service Pionniers"),
        JobItem("Cargo Vip", 23.50, "CARGO", "Service Pionniers"),
        JobItem("Cargo Prio Zone2", 24.00, "CARGO", "Service Pionniers"),
        JobItem("Cargo Vip Zone2", 45.00, "CARGO", "Service Pionniers"),
        
        // GME
        JobItem("GME", 6.48, "GME", "Service Pionniers"),
        JobItem("GME 400+", 12.00, "GME", "Service Pionniers"),
        JobItem("GME Zone2", 7.20, "GME", "Service Pionniers"),
        
        // AUTRE
        JobItem("Attente (15 min)", 4.00, "AUTRE", "Service Pionniers")
    )
    
//    val alljobs = noveaJobs + pionniersJobs
}
