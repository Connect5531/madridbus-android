package com.quoders.apps.madridbus;

import android.support.v4.app.Fragment;

public abstract class BaseFragment extends Fragment {

  protected <C> C getComponent(Class<C> componentType) {
    return componentType.cast(((HasComponent<C>) getActivity()).getComponent());
  }
}
