package com.wallet.zindigi.hamburgermenu.datahandler

import androidx.compose.runtime.Composable
import com.components.hospitalcaresystem.R
import com.components.hospitalcaresystem.presentation.components.listsheet.TestItem


/**
 * Will be replaced by ViewModels Once APIs are ready and functional
 */
object HospitalCareDataHandler{
    /**
     * Get Main Menu list from [getDoctorsList]
     */
    @Composable
    fun getDoctorsList(): List<TestItem> {
        return listOf(
            TestItem(
                title = "Dr.Shouey",
                description = "Specialist Cardiology",
                image = R.drawable.img_doc1
            ),
            TestItem(
                title = "Dr.Arman Malik",
                description = "Medicine Specialist",
                image = R.drawable.img_doc2
            ),
            TestItem(
                title = "Dr.Christenfeld N",
                description = "Cancer Specialist",
                image = R.drawable.img_doc3
            ),
            TestItem(
                title = "Dr. Crick",
                description = "Pathology Specialist",
                image = R.drawable.img_doc4
            ),
            TestItem(
                title = "Dr.Shouey",
                description = "Specialist Cardiology",
                image = R.drawable.img_doc1
            ),
            TestItem(
                title = "Dr.Arman Malik",
                description = "Medicine Specialist",
                image = R.drawable.img_doc2
            ),
            TestItem(
                title = "Dr.Christenfeld N",
                description = "Cancer Specialist",
                image = R.drawable.img_doc3
            ),
            TestItem(
                title = "Dr. Crick",
                description = "Pathology Specialist",
                image = R.drawable.img_doc4
            ),
        )
    }

    @Composable
    fun getDashboarDatea(): List<TestItem> {
        return listOf(
            TestItem(
                title = "Appointment",
                image = R.drawable.img_splash
            ),
            TestItem(
                title = "Ask a Doctor",
                image = R.drawable.img_splash
            ),
            TestItem(
                title = "Special Visit",
                image = R.drawable.img_splash
            ),
            TestItem(
                title = "Emergency Call",
                image = R.drawable.img_splash
            )
        )
    }

}