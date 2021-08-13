package com.example.incomeexpenditure.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import androidx.fragment.app.DialogFragment
import com.example.incomeexpenditure.R
import com.example.incomeexpenditure.data.IncomeExpenditure
import kotlinx.android.synthetic.main.dialog.view.*
import java.lang.RuntimeException

class IncomeExpenditureDialog: DialogFragment() {

    interface DialogHandler {
        fun itemCreated(item: IncomeExpenditure)
    }

    lateinit var dialogHandler: DialogHandler

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is DialogHandler) {
            dialogHandler = context
        } else {
            throw RuntimeException("The Activity is not implementing the TodoHandler interface.")
        }
    }

    lateinit var etType: EditText
    lateinit var etAmount: EditText
    lateinit var spinner: Spinner

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialogBuilder = AlertDialog.Builder(requireContext())

        val dialogView = requireActivity().layoutInflater.inflate(R.layout.dialog, null)

        etType = dialogView.etType
        etAmount = dialogView.etAmount
        spinner = dialogView.spinner

        var categoryAdapter = ArrayAdapter.createFromResource(requireActivity(),
            R.array.category_array, android.R.layout.simple_spinner_item)

        categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = categoryAdapter

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
            if (etType.text.isNotEmpty()) {
                if (etAmount.text.isNotEmpty()) {
                    handleItemCreate()
                    dialog.dismiss()
                } else {
                    etAmount.error = "This field can not be empty"
                }
            } else {
                etType.error = "This field can not be empty"
            }
        }
    }

    fun handleItemCreate() {
        dialogHandler.itemCreated(IncomeExpenditure(null, etType.text.toString(), etAmount.text.toString(),
            spinner.selectedItemPosition))
    }

}