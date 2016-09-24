package org.wit.callback;

//Class to simulate a short-lived event loop
public class EventLoop
{
public static void main(String[] args)
{
 TextWatcher textwatcher = new Callback();
 TextView textview = new TextView();
 textview.addTextChangedListener(textwatcher);

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
