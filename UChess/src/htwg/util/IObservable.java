/*
 * Decompiled with CFR 0_114.
 */
package htwg.util;

import htwg.util.Event;
import htwg.util.IObserver;

public interface IObservable {
    public void addObserver(IObserver var1);

    public void removeObserver(IObserver var1);

    public void removeAllObservers();

    public void notifyObservers();

    public void notifyObservers(Event var1);
}

