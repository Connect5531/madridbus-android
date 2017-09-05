package com.quoders.apps.madridbus.ui.home;


import com.quoders.apps.madridbus.ApplicationComponent;
import com.quoders.apps.madridbus.di.FragmentScoped;

import dagger.Component;

@FragmentScoped
@Component(dependencies = ApplicationComponent.class, modules = HomePresenterModule.class)
public interface HomeComponent {

    void inject(HomeActivity homeActivity);
}
