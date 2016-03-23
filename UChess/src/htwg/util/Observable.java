/*
 * Decompiled with CFR 0_114.
 */
package htwg.util;

import htwg.util.Event;
import htwg.util.IObservable;
import htwg.util.IObserver;
import java.util.ArrayList;
import java.util.List;

public class Observable
implements IObservable {
    private List<IObserver> subscribers = new ArrayList<IObserver>(2);

    @Override
    public void addObserver(IObserver s) {
        this.subscribers.add(s);
    }

    @Override
    public void removeObserver(IObserver s) {
        this.subscribers.remove(s);
    }

    @Override
    public void removeAllObservers() {
        this.subscribers.clear();
    }

    @Override
    public void notifyObservers() {
        this.notifyObservers(null);
    }

    @Override
    public void notifyObservers(Event e) {
        for (IObserver observer : this.subscribers) {
            observer.update(e);
        }
    }
}

