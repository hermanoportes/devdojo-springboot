package pt.hermanoportes.springbootessentials.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.hermanoportes.springbootessentials.model.Cartoon;
import pt.hermanoportes.springbootessentials.util.DateUtil;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.Arrays.asList;

@RestController
@RequestMapping("cartoons")
@Log4j2
@RequiredArgsConstructor
public class CartoonController {
    private final DateUtil dateUtil;

    @GetMapping(path="list")
    public List<Cartoon> list() {
        log.info(dateUtil.formatLocalDateTimetoDatabaseStyle(LocalDateTime.now()));
        return List.of(new Cartoon("Adventure Time"), new Cartoon("Steven Universe"), new Cartoon("Irmão do Jorel"));
    }
}
