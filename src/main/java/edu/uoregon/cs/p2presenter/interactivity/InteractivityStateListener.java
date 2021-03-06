package edu.uoregon.cs.p2presenter.interactivity;

/** The listener interface for recieving state events for a particular state object.
 * @author rberdeen
 *
 */
public interface InteractivityStateListener<T extends InteractivityModel> {
	public void stateChanged(T state);
}
