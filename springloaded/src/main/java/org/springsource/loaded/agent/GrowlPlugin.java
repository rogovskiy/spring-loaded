package org.springsource.loaded.agent;

import org.springsource.loaded.ReloadEventProcessorPlugin;

import java.io.IOException;

/**
 * Shows a notification when classes are reloaded.
 */
public class GrowlPlugin implements ReloadEventProcessorPlugin {

  @Override
  public boolean shouldRerunStaticInitializer(String typename, Class<?> clazz, String encodedTimestamp) {
    return false;
  }

  @Override
  public void reloadEvent(String typename, Class<?> clazz, String encodedTimestamp) {
    String growlLocation = System.getProperty("growlnotify.path");
    if (growlLocation != null) {
      try {
        Runtime.getRuntime().exec(new String[] { growlLocation, "/a:SpringLoaded", "/t:Reloaded", "/n:Grails", typename});
      } catch (IOException e) {
        // ignore
      }
    }
  }
}
