package com.example.myrecyclerviewapp

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.myrecyclerviewapp.ImageLoader
import com.example.myrecyclerviewapp.model.EmployeeRole
import com.example.myrecyclerviewapp.model.EmployeeUiModel
import com.example.myrecyclerviewapp.model.Gender

private val FEMALE_SYMBOL by lazy {
    HtmlCompat.fromHtml("&#9793;", HtmlCompat.FROM_HTML_MODE_LEGACY)
}
private val MALE_SYMBOL by lazy {
    HtmlCompat.fromHtml("&#9794;", HtmlCompat.FROM_HTML_MODE_LEGACY)
}
private const val UNKNOWN_SYMBOL ="?"
class EmployeeViewHolder(containerView: View, private val imageLoader: ImageLoader): RecyclerView.ViewHolder(containerView) {
    private val employeeRoleView: TextView by lazy {
        containerView.findViewById(R.id.item_employee_role)
    }
    private val employeeGenderView: TextView by lazy {
        containerView.findViewById(R.id.item_employee_gender)
    }
    private val employeeNameView: TextView
            by lazy { containerView.findViewById(R.id.item_employee_name) }
    private val employeePhotoView: ImageView
            by lazy { containerView.findViewById(R.id.item_employee_photo) }

    fun bindData(employeeData: EmployeeUiModel) {
        imageLoader.loadImage(employeeData.imageUrl, employeePhotoView)
        employeeNameView.text = employeeData.name
        employeeRoleView.text = when (employeeData.role) {
            EmployeeRole.HumanResources -> "American Curl"
            EmployeeRole.Management -> "Balinese-Javanese"
            EmployeeRole.Technology -> "Exotic Shorthair"
        }
        employeeGenderView.text = when (employeeData.gender) {
            Gender.Female -> FEMALE_SYMBOL
            Gender.Male -> MALE_SYMBOL
            else -> UNKNOWN_SYMBOL
        }
    }
}