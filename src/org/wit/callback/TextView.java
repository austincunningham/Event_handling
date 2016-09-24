package org.wit.callback;

public class TextView
{
  private TextWatcher textwatcher;
  private boolean somethingHappened;

  public void addTextChangedListener(TextWatcher textwatcher)
  {
    // Save the event object for later use.
    this.textwatcher = textwatcher;
    // Nothing to report yet.
    somethingHappened = false;
  }

  // Invoking with flag == true sets scene for a callback
  public void setPredicate(boolean flag)
  {
    somethingHappened = flag;
  }

  // This method will be invoked repeatedly in an event loop
  public void doWork()
  {
    // Check the predicate, which is set elsewhere.
    if (somethingHappened)
    {
      // Signal the event by invoking the interface's method.
      textwatcher.onTextChanged("Finally - you called back");
      somethingHappened = false;
    }
  }
}
