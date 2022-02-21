package com.matdev.tam_projekt

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.closeSoftKeyboard
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.matdev.tam_projekt.View.LoginActivity
import org.hamcrest.CoreMatchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class LoginActivityTest {

    @get:Rule
    val activityScenarioRule : ActivityScenarioRule<LoginActivity> =
        ActivityScenarioRule(LoginActivity::class.java)

    @Test
    fun uruchomienie_ekranu_powinno_pokazac_odpowiednie_widoki() {

        onView(withId(R.id.loginLayout)).check(matches(isDisplayed()))
        onView(withId(R.id.hasloLayout)).check(matches(isDisplayed()))
        onView(withId(R.id.loginMe)).check(matches(isDisplayed()))

        onView(withId(R.id.progressbar)).check(matches(not(isDisplayed())))
    }

    @Test
    fun klikniecie_w_przycisk_bez_danych_powinno_pokazac_progress_oraz_blad() {

        onView(withId(R.id.loginMe)).perform(click())
        //onView(withId(R.id.progressbar)).check(matches(isDisplayed()))

        Thread.sleep(2000)

        onView(withId(R.id.loginInput)).check(matches(hasErrorText("Username can't be empty!")))
    }



    @Test
    fun zalogowanie_po_podaniu_prawidłowych_danych() {

        onView(withId(R.id.loginInput)).perform(typeText("mnowak"));

        onView(withId(R.id.hasloInput)).perform(typeText("12345"));

        onView(withId(R.id.loginMe)).perform(click())

        Thread.sleep(2000)

        Espresso.onView(ViewMatchers.withId(R.id.saldo_total)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.saldo)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.tablica)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(ViewMatchers.withId(R.id.budżet)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.wydatki)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))


        Espresso.onView(ViewMatchers.withId(R.id.widok_tytuł)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.widok)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

    }
}

