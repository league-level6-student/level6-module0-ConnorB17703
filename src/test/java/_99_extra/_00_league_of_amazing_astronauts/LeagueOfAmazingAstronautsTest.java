package _99_extra._00_league_of_amazing_astronauts;

import _99_extra._00_league_of_amazing_astronauts.LeagueOfAmazingAstronauts;
import _99_extra._00_league_of_amazing_astronauts.models.Astronaut;
import _99_extra._00_league_of_amazing_astronauts.models.Rocketship;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

/*

When writing the tests, mock both the Rocketship and Astronaut for the sake of practice.
 */
class LeagueOfAmazingAstronautsTest {

    LeagueOfAmazingAstronauts underTest = new LeagueOfAmazingAstronauts();

    @Mock 
    Rocketship rocketship;
    
    @Mock
    Astronaut astronaut;
    
    Astronaut astro = new Astronaut(); 
    
    
    @BeforeEach
    void setUp() {
    	MockitoAnnotations.openMocks(this);
    	
    }

    @Test
    //keeps coming out as not trained
    void itShouldPrepareAstronaut() {
        //given
    	boolean expectedResults  = true;    	
    	
        //when
    	underTest.prepareAstronaut(astro);
    	//astronaut.train();
    	//when(astronaut.isTrained()).thenReturn(true);
    	
        //then
    	
    	//verify(underTest, times(1)).prepareAstronaut(astronaut);
    	assertEquals(expectedResults, astro.isTrained());
    	
    }

    @Test
    void itShouldLaunchRocket() {
        //given
    	underTest.setRocketship(rocketship);
    	
    	
        //when
    	when(rocketship.isLoaded()).thenReturn(true);
    	underTest.launchRocket("Mars");
    	
    	
        //then
    	verify(rocketship, times(1)).launch();
    	
    }


    @Test
    void itShouldThrowWhenDestinationIsUnknown() {
        //given
    	underTest.setRocketship(rocketship);
    	//rocketship.setDestination("Venus", 20000);
    	
        //when
    	when(rocketship.isLoaded()).thenReturn(true);
    	
    	
        //then
    	assertThrows(Exception.class, ()-> underTest.launchRocket("Venus"));
    	
    }

    @Test
    void itShouldThrowNotLoaded() {
        //given
    	underTest.setRocketship(rocketship);
    	
        //when
    	underTest.launchRocket("Mars");
    	
        //then
    	assertThrows(IllegalStateException.class, ()-> underTest.launchRocket("Mars"));
    	//not checking correctly
    	
    	
    }
}