package com.quoders.apps.madridbus.ui.lines;

import com.quoders.apps.madridbus.utils.FragmentScoped;
import com.quoders.apps.madridbus.MadridBusAppComponent;

import dagger.Component;

@FragmentScoped
@Component(dependencies = MadridBusAppComponent.class)
public interface LinesComponent {

    void inject(LinesFragment fragment);
}

