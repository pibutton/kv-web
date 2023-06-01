package hu.nye.progkor.kvweb.service.impl;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import java.util.List;
import java.util.Optional;

import hu.nye.progkor.kvweb.data.model.Kave;
import hu.nye.progkor.kvweb.data.model.Porkoles;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import hu.nye.progkor.kvweb.data.repository.Repository;
import hu.nye.progkor.kvweb.service.KaveService;


class DefaultKaveServiceTest {

    private static final Long DUMMY_KAVE_ID = 1L;
    private static final Kave DUMMY_KAVE = new Kave(DUMMY_KAVE_ID, "String marka", "String eredet", "String fajta", "String savassag",
            "String kiszereles", Porkoles.KOZEPES);

    @Mock
    private Repository<Kave, Long> kaveRepository;

    private KaveService underTest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        underTest = new DefaultKaveService(kaveRepository);
    }

    @Test
    void createKaveShouldDelegateToTheRepositoryAndReturnSavedKave() {
        // Given
        given(kaveRepository.save(DUMMY_KAVE)).willReturn(DUMMY_KAVE);

        // When
        final Kave actual = underTest.createKave(DUMMY_KAVE);

        // Then
        assertThat(actual, equalTo(DUMMY_KAVE));
        verify(kaveRepository).save(DUMMY_KAVE);
        verifyNoMoreInteractions(kaveRepository);
    }

    @Test
    void retrieveKaveByIdShouldDelegateToTheRepositoryAndReturnFoundKave() {
        // Given
        given(kaveRepository.getById(DUMMY_KAVE_ID)).willReturn(Optional.of(DUMMY_KAVE));

        // When
        final Optional<Kave> actual = underTest.retrieveKaveById(DUMMY_KAVE_ID);

        // Then
        assertThat(actual, equalTo(Optional.of(DUMMY_KAVE)));
        verify(kaveRepository).getById(DUMMY_KAVE_ID);
        verifyNoMoreInteractions(kaveRepository);
    }

    @Test
    void retrieveAllKavekShouldDelegateToTheRepositoryAndReturnAllFoundKavek() {
        // Given
        given(kaveRepository.getAll()).willReturn(List.of(DUMMY_KAVE));

        // When
        final List<Kave> actual = underTest.retrieveAllKavek();

        // Then
        assertThat(actual, equalTo(List.of(DUMMY_KAVE)));
        verify(kaveRepository).getAll();
        verifyNoMoreInteractions(kaveRepository);
    }

    @Test
    void updateKaveShouldDelegateToTheRepositoryAndReturnKave() {
        // Given
        given(kaveRepository.update(DUMMY_KAVE)).willReturn(DUMMY_KAVE);

        // When
        final Kave actual = underTest.updateKave(DUMMY_KAVE);

        // Then
        assertThat(actual, equalTo(DUMMY_KAVE));
        verify(kaveRepository).update(DUMMY_KAVE);
        verifyNoMoreInteractions(kaveRepository);
    }

    @Test
    void deleteKaveByIdShouldRemoveKaveFromRepository() {
        // Given
        final int givenSize = 0;

        // When
        kaveRepository.deleteById(1L);
        int actualSize = kaveRepository.size();

        // Then
        assertThat(actualSize, equalTo(givenSize));

    }
}