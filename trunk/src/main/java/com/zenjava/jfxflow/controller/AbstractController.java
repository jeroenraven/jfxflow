/*
 * Copyright (c) 2011, Daniel Zwolenski. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3.0 of the License, or any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
 */
package com.zenjava.jfxflow.controller;

import com.zenjava.jfxflow.navigation.Place;
import javafx.beans.property.*;
import javafx.fxml.Initializable;
import javafx.scene.Node;

import java.net.URL;
import java.util.ResourceBundle;

public abstract class AbstractController<ViewType extends Node, PlaceType extends Place>
        implements Controller<ViewType, PlaceType>, Initializable, HasFxmlLoadedView<ViewType>
{
    private ViewType view;
    private ObjectProperty<PlaceType> currentPlace;
    private BooleanProperty active;
    private BooleanProperty busy;

    protected AbstractController()
    {
        currentPlace = new SimpleObjectProperty<PlaceType>();
        active = new SimpleBooleanProperty();
        busy = new SimpleBooleanProperty();
    }

    public void setView(ViewType view)
    {
        this.view = view;
    }

    public ViewType getView()
    {
        return view;
    }

    public void initialize(URL url, ResourceBundle resourceBundle)
    {
    }

    public void activate(PlaceType place)
    {
        currentPlace.set(place);
        active.set(true);
    }

    public void deactivate()
    {
        currentPlace.set(null);
        active.set(false);
    }

    public PlaceType getCurrentPlace()
    {
        return currentPlace.get();
    }

    public ReadOnlyObjectProperty<PlaceType> currentPlaceProperty()
    {
        return currentPlace;
    }

    public boolean isActive()
    {
        return active.get();
    }

    public BooleanProperty activeProperty()
    {
        return active;
    }

    public boolean isBusy()
    {
        return busy.get();
    }

    public void setBusy(boolean busy)
    {
        this.busy.set(busy);
    }

    public BooleanProperty busyProperty()
    {
        return busy;
    }
}
