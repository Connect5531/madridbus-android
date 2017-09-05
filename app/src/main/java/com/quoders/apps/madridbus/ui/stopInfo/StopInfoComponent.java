package com.quoders.apps.madridbus.ui.stopInfo;


import com.quoders.apps.madridbus.ApplicationComponent;
import com.quoders.apps.madridbus.di.FragmentScoped;
import com.quoders.apps.madridbus.domain.repository.stopInfo.StopInfoRepositoryModule;

import dagger.Component;

@FragmentScoped
@Component(dependencies = ApplicationComponent.class, modules = {StopInfoPresenterModule.class, StopInfoRepositoryModule.class})
public interface StopInfoComponent {

    void inject(StopInfoActivity stopInfoActivity);
}
