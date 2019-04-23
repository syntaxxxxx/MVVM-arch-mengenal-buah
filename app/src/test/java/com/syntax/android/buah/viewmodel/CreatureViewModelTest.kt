//
//package com.syntax.android.buah.viewmodel
//
//import android.arch.core.executor.testing.InstantTaskExecutorRule
//
//import com.syntax.android.buah.model.Buah
//import com.syntax.android.buah.model.BuahAttribute
//import com.syntax.android.buah.model.BuahGenerate
//import com.syntax.android.buah.model.BuahRepository
//import com.syntax.android.buah.view.detail.DetailViewModel
//import junit.framework.Assert.assertEquals
//import org.junit.Before
//import org.junit.Rule
//import org.junit.Test
//import org.junit.rules.TestRule
//import org.mockito.Mock
//import org.mockito.Mockito.`when`
//import org.mockito.MockitoAnnotations
//
//class CreatureViewModelTest {
//
//  private lateinit var creatureViewModel: DetailViewModel
//
//  @get:Rule
//  var rule: TestRule = InstantTaskExecutorRule()
//
//  @Mock
//  lateinit var mockGenerator: BuahGenerate
//
//  @Mock
//  lateinit var repository: BuahRepository
//
//  @Before
//  fun setup() {
//    MockitoAnnotations.initMocks(this)
//    creatureViewModel = DetailViewModel(mockGenerator, repository)
//  }
//
//  @Test
//  fun testSetupCreature() {
//    val attributes = BuahAttribute(10, 3, 7)
//    val stubCreature = Buah(attributes, 87, "Test Buah")
//    `when`(mockGenerator.generateCreature(attributes)).thenReturn(stubCreature)
//
//    creatureViewModel.intelligence = 10
//    creatureViewModel.strength = 3
//    creatureViewModel.endurance = 7
//
//    creatureViewModel.updateCreature()
//
//    assertEquals(stubCreature, creatureViewModel.creature)
//  }
//
//  @Test
//  fun testCantSaveCreatureWithBlankName() {
//    creatureViewModel.intelligence = 10
//    creatureViewModel.strength = 3
//    creatureViewModel.endurance = 7
//    creatureViewModel.drawable = 1
//    creatureViewModel.name = ""
//    val canSaveCreature = creatureViewModel.canSaveCreature()
//    assertEquals(false, canSaveCreature)
//  }
//
//  @Test
//  fun testCantSaveCreatureWithoutStrength() {
//    creatureViewModel.intelligence = 10
//    creatureViewModel.strength = 0
//    creatureViewModel.endurance = 7
//    creatureViewModel.drawable = 1
//    creatureViewModel.name = "My Buah"
//    val canSaveCreature = creatureViewModel.canSaveCreature()
//    assertEquals(false, canSaveCreature)
//  }
//}