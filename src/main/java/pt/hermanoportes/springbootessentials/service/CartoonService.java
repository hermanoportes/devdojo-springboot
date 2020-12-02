package pt.hermanoportes.springbootessentials.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pt.hermanoportes.springbootessentials.model.Cartoon;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class CartoonService {
    private List<Cartoon> cartoonList = new ArrayList<>(List.of(
            new Cartoon(1L, "Adventure Time"),
            new Cartoon(2L, "Steven Universe"),
            new Cartoon(3L, "Irmão do Jorel")));
    //private final CartoonRepository cartoonRepository;

    public List<Cartoon> listAll() {
        return this.cartoonList;
    }

    public Cartoon findById(long id) {
        return cartoonList.stream()
                .filter(cartoon -> cartoon.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cartoon not found for id=" + id));
    }

    public Cartoon save(Cartoon cartoon) {
        cartoon.setId(ThreadLocalRandom.current().nextLong(4, 1000000));
        cartoonList.add(cartoon);
        return cartoon;
    }
}
