package controller;

import com.king.controller.HomeController;
import com.king.controller.SpittleController;
import com.king.model.Spittle;
import com.king.service.SpittleRepository;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;


/**
 * Created by jin82 on 2016/06/10.
 */
public class HomeControllerTest {
    @Test
    public void testHomePage() throws Exception{
        HomeController homeController = new HomeController();
        MockMvc mockMvc = standaloneSetup(homeController).build();
        mockMvc.perform(get("/")).andExpect(view().name("home"));

    }

    @Test
    public void shouldShowRecentSpittles() throws  Exception{
        List<Spittle> expectedSpittles = createSpittleList(20);
        SpittleRepository mockRepository = Mockito.mock(SpittleRepository.class);
        when(mockRepository.findSpittles(Long.MAX_VALUE,20)).thenReturn(expectedSpittles);
        SpittleController spittleController = new SpittleController(mockRepository);
        MockMvc mockMvc = standaloneSetup(spittleController).setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp")).build();

        mockMvc.perform(get("/spittles"))
                .andExpect(view().name("spittles"))
                .andExpect(model().attributeExists("spittleList"))
                .andExpect(model().attribute("spittleList",hasItems(expectedSpittles.toArray())));

    }

    private List<Spittle> createSpittleList(int count){
        List<Spittle> spittles = new ArrayList<Spittle>();
        for(int i=0;i<count;i++){
            spittles.add(new Spittle(new Date(),"Spittle "+i));
        }
        return spittles;
    }
}
