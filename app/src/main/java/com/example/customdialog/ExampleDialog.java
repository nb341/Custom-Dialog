package com.example.customdialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
 interface ExampleDialogListener{
     public void applyText(String username, String password);

 }


public class ExampleDialog extends AppCompatDialogFragment {
    private EditText userName, pWord;
     private ExampleDialogListener listener;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try { listener = (ExampleDialogListener) context;
        }
        catch (ClassCastException e)
        { throw new ClassCastException(context.toString()+ "implement DialogListener");
        }
    }

    @Override

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog, null);

        builder.setView(view)
                .setTitle("Login")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {


               String username = userName.getText().toString();
                                     String password = pWord.getText().toString();
                listener.applyText(username,password);
            }
        });

        userName = view.findViewById(R.id.username);
        pWord = view.findViewById(R.id.password);
        return builder.create();
    }
}
