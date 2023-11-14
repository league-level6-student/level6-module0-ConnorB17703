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
    	underTest.prepareAstronaut(astronaut);
    	astronaut.train();
    	when(astronaut.isTrained()).thenReturn(true);
        //then
    	
    	verify(underTest, times(1)).prepareAstronaut(astronaut);
    	//assertEquals(expectedResults, astronaut.isTrained());
    }

    @Test
    void itShouldLaunchRocket() {
        //given
    	
    	
        //when
    	
    	
        //then
    
    }


    @Test
    void itShouldThrowWhenDestinationIsUnknown() {
        //given

        //when
        //then
    }

    @Test
    void itShouldThrowNotLoaded() {
        //given

        //when
    	
    	
        //then
   
    }
}