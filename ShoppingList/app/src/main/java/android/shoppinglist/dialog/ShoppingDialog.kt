package android.shoppinglist.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.shoppinglist.R
import android.shoppinglist.data.ShoppingList
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.item_row.*
import kotlinx.android.synthetic.main.shoppig_dialog.view.*

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


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialogBuilder = AlertDialog.Builder(requireContext())

        dialogBuilder.setTitle("Shop dialog")
        val dialogView = requireActivity().layoutInflater.inflate(R.layout.shoppig_dialog, null)

        etName = dialogView.etName
        etPrice = dialogView.etPrice

        dialogBuilder.setView(dialogView)


        dialogBuilder.setPositiveButton("Ok") {
                dialog, which ->

            shoppingHandler.itemCreated(
                ShoppingList(etName.text.toString(), etPrice.text.toString(),false)
            )
        }
        dialogBuilder.setNegativeButton("Cancel") {
                dialog, which ->
        }


        return dialogBuilder.create()
    }
    override fun onResume() {
        super.onResume()

        etName.requestFocus()

        val inputMethodManager =
            context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.toggleSoftInput(
            InputMethodManager.SHOW_FORCED,
            0
        )
    }

}