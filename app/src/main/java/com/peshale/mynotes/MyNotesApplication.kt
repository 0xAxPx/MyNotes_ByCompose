package com.peshale.mynotes

import android.app.Application
import com.peshale.mynotes.dependencyinjection.DependencyInjector


/**
 * Application class responsible for initializing the dependency injector.
 */
class MyNotesApplication : Application() {

  lateinit var dependencyInjector: DependencyInjector

  override fun onCreate() {
    super.onCreate()
    initDependencyInjector()
  }

  private fun initDependencyInjector() {
    dependencyInjector = DependencyInjector(this)
  }
}
