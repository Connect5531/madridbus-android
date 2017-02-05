package com.quoders.apps.madridbus.ui.home;


import com.quoders.apps.madridbus.utils.FragmentScoped;
import com.quoders.apps.madridbus.MadridBusAppComponent;

import dagger.Component;

@FragmentScoped
@Component(dependencies = MadridBusAppComponent.class, modules = HomePresenterModule.class)
public interface HomeComponent {

    void inject(HomeActivity homeActivity);
}
