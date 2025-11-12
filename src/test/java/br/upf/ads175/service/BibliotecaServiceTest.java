package br.upf.ads175.service;

import br.upf.ads175.entity.Autor;
import br.upf.ads175.repository.AutorRepository;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
public class BibliotecaServiceTest {

    @Inject
    private BibliotecaService bibliotecaService;

    @InjectMock
    private AutorRepository autorRepository;

    @Test
    public void testListarTodosAutores() {
        List<Autor> autoresMock = new ArrayList<>();
        autoresMock.add(new Autor());
        autoresMock.add(new Autor());

        Mockito.when(autorRepository.findAll()).thenReturn(autoresMock);

        List<Autor> autores = bibliotecaService.listarTodosAutores();

        assertNotNull(autores);
        assertEquals(2, autores.size());
    }

    @Test
    public void testListarTodosAutoresComSeusLivros() {
        List<Autor> autoresMock = new ArrayList<>();
        autoresMock.add(new Autor());
        autoresMock.add(new Autor());

        Mockito.when(autorRepository.findAllComLivros()).thenReturn(autoresMock);

        List<Autor> autores = bibliotecaService.listarTodosAutoresComSeusLivros();

        assertNotNull(autores);
        assertEquals(2, autores.size());
    }

    @Test
    public void testContarTotalAutores() {
        Mockito.when(autorRepository.count()).thenReturn(5L);

        Long count = bibliotecaService.contarTotalAutores();

        assertNotNull(count);
        assertEquals(5L, count);
    }
}
