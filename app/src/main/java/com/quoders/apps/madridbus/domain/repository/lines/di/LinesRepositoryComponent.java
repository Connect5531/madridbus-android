package com.quoders.apps.madridbus.domain.repository.lines.di;


import com.quoders.apps.madridbus.ApplicationComponent;
import com.quoders.apps.madridbus.ApplicationModule;
import com.quoders.apps.madridbus.di.FragmentScoped;
import com.quoders.apps.madridbus.domain.network.NetworkModule;
import com.quoders.apps.madridbus.domain.repository.lines.LinesRepository;
import com.quoders.apps.madridbus.ui.lines.LinesFragment;
import com.quoders.apps.madridbus.ui.lines.LinesPresenterModule;

import javax.inject.Singleton;

import dagger.Component;

@FragmentScoped
@Component(dependencies = ApplicationComponent.class, modules = {LinesRepositoryModule.class, LinesPresenterModule.class})
public interface LinesRepositoryComponent {

    LinesRepository getTasksRepository();
}
