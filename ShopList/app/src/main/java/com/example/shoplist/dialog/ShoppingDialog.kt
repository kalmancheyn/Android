package com.example.shoplist.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import androidx.fragment.app.DialogFragment
import com.example.shoplist.R
import com.example.shoplist.data.ShoppingList
import kotlinx.android.synthetic.main.shopping_dialog.*
import kotlinx.android.synthetic.main.shopping_dialog.view.*

class ShoppingDialog: DialogFragment() {

    interface ShoppingHandler{
        fun itemCreated(shop: ShoppingList)
    }

    lateinit var shoppingHandler: ShoppingHandler

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ShoppingHandler){
            shoppingHandler = context
        } else {
            throw RuntimeException("The Activity is not implementing the TodoHandler interface.")
        }
    }

    lateinit var etName: EditText
    lateinit var etPrice: EditText
    lateinit var spinnerCategory: Spinner
    lateinit var etDescription: EditText


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialogBuilder = AlertDialog.Builder(requireContext())

        val dialogView = requireActivity().layoutInflater.inflate(R.layout.shopping_dialog, null)

        etName = dialogView.etName
        etPrice = dialogView.etPrice
        spinnerCategory = dialogView.spinnerCategory
        etDescription = dialogView.etDescription
        var categoryAdapter = ArrayAdapter.createFromResource(requireActivity(),
            R.array.category_array, android.R.layout.simple_spinner_item)

        categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerCategory.adapter = categoryAdapter

        dialogBuilder.setView(dialogView)


        dialogBuilder.setPositiveButton("Ok") {
                dialog, which ->


        }
        dialogBuilder.setNegativeButton("Cancel") {
                dialog, which ->
        }
        return dialogBuilder.create()
    }
    override fun onResume() {
        super.onResume()

        val dialog = dialog as AlertDialog
        val positiveButton = dialog.getButton(Dialog.BUTTON_POSITIVE)

        positiveButton.setOnClickListener {
            if (etName.text.isNotEmpty()) {
                if (etPrice.text.isNotEmpty()) {
                    handleItemCreate()
                    dialog.dismiss()
                } else {
                    etPrice.error = "This field can not be empty"
                }
            } else {
                etName.error = "This field can not be empty"
            }
        }
    }

    fun handleItemCreate() {
        shoppingHandler.itemCreated(ShoppingList(null, etName.text.toString(), etPrice.text.toString(),
            false, spinnerCategory.selectedItemPosition, etDescription.text.toString()))
    }

}