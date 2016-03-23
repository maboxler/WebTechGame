/*
 * Decompiled with CFR 0_114.
 * 
 * Could not load the following classes:
 *  com.google.inject.AbstractModule
 *  com.google.inject.binder.AnnotatedBindingBuilder
 *  com.google.inject.binder.ScopedBindingBuilder
 */
package htwg.se.chess;

import com.google.inject.AbstractModule;
import com.google.inject.binder.AnnotatedBindingBuilder;
import com.google.inject.binder.ScopedBindingBuilder;
import htwg.se.controller.ChessController;
import htwg.se.controller.Icontroller;

public class ChessModule
extends AbstractModule {
    protected void configure() {
        this.bind((Class)Icontroller.class).to((Class)ChessController.class);
    }
}

