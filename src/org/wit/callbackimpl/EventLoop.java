package org.wit.callbackimpl;

import org.wit.callback.TextView;
import org.wit.callback.TextWatcher;

//Class to simulate a short-lived event loop
public class EventLoop implements TextWatcher
{

  public void runloop()
  {    
    TextView textview = new TextView();

    // EventLoop implements TextWatcher
    // Consequently "this" a legal parameter here
    textview.addTextChangedListener(this);

    // The simulated event loop
    int val = 0;
    do
    {
      if (val % 100 == 0)
      {
        textview.setPredicate(true); // the trigger to fire an event
      }
      textview.doWork();// invoked repeatedly, triggers event when predicate true
      val += 1;
    } while (val < 500);// we expect 5 events to be triggered 
  }
  public static void main(String[] args)
  {
    EventLoop obj = new EventLoop();
    obj.runloop();

  }

  @Override
  public void onTextChanged(String changedtext)
  {
    System.out.println(changedtext);

  }
}