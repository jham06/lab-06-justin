package com.example.lab_6

import org.junit.Before
import org.junit.Test
import junit.framework.TestCase.assertEquals


private lateinit var evilWizard: Wizard
class WizardTest {

    // Set up a new wizard before every single test
    @Before
    fun setUp() {
        evilWizard = Wizard("Evil Wizard", 30, 10)
    }

    @Test
    fun castSpell_explosion_successful() {
        val damageDealt = com.example.lab_6.evilWizard.castSpell("Explosion")

        assertEquals(30, damageDealt) // spellPower of 10 * 3 = 30

        assertEquals(20, com.example.lab_6.evilWizard.mana) // mana of 30 - 10 = 20
    }

    @Test
    fun castSpell_explosion_unsuccessful() {
        com.example.lab_6.evilWizard.mana = 5 // Evil Wizard does not have enough mana to cast "Explosion"
        val damageDealt = com.example.lab_6.evilWizard.castSpell("Explosion")

        assertEquals(0, damageDealt)

        assertEquals(5, com.example.lab_6.evilWizard.mana) // mana still is 5
    }

    @Test
    fun castSpell_frostbite_successful() {
        val damageDealt = com.example.lab_6.evilWizard.castSpell("Frostbite")

        assertEquals(20, damageDealt) // spellPower of 10 * 2 = 20

        assertEquals(25, com.example.lab_6.evilWizard.mana) // mana of 20 - 5
    }


    @Test
    fun castSpell_frostbite_unsuccessful() {
        com.example.lab_6.evilWizard.mana = 2
        val damageDealt = com.example.lab_6.evilWizard.castSpell("Frostbite")

        assertEquals(0, damageDealt) // spellPower of nothing

        assertEquals(2, com.example.lab_6.evilWizard.mana) // mana is still 2
    }
}