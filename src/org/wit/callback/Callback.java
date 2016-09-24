package org.wit.callback;

public class Callback implements TextWatcher
{
    @Override
    public void onTextChanged(String changedtext)
    {
      System.out.println(changedtext);
    } 
}