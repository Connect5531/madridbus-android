package com.quoders.apps.madridbus.ui.lines;

import com.quoders.apps.madridbus.ApplicationComponent;
import com.quoders.apps.madridbus.di.FragmentScoped;
import com.quoders.apps.madridbus.domain.repository.lines.LinesRepositoryModule;

import dagger.Component;

@FragmentScoped
@Component(dependencies = ApplicationComponent.class, modules = {LinesPresenterModule.class, LinesRepositoryModule.class})
public interface LinesComponent {

    void inject(LinesFragment linesFragment);

}

