package org.wit.callbackanon;

import org.wit.callback.TextView;
import org.wit.callback.TextWatcher;

//Class to simulate a short-lived event loop
public class EventLoop
{
public static void main(String[] args)
{
 TextView textview = new TextView();
 textview.addTextChangedListener(new TextWatcher()
 {
   @Override
   public void onTextChanged(String changedtext)
   {
     System.out.println(changedtext);
   }

 });

 int val = 0;
 // The simulated event loop
 do
 {
   if (val % 100 == 0)
   {
     textview.setPredicate(true); // the trigger to fire an event
   }
   // invoke repeatedly but trigger event only when predicate true
   textview.doWork();
   val += 1;
 } while (val < 500);// we expect 5 events to be triggered
}
}
