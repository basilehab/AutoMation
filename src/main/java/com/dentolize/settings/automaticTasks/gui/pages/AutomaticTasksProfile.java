package com.dentolize.settings.automaticTasks.gui.pages;

import com.shaft.driver.SHAFT;
import components.CommonLocators;

public class AutomaticTasksProfile {
    private final SHAFT.GUI.WebDriver driver;
    public CommonLocators commonLocators;

    public AutomaticTasksProfile(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
}
