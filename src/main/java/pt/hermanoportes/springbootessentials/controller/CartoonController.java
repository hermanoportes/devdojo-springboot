package pt.hermanoportes.springbootessentials.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.hermanoportes.springbootessentials.model.Cartoon;
import pt.hermanoportes.springbootessentials.service.CartoonService;
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
    private final CartoonService cartoonService;

    @GetMapping
    public ResponseEntity list() {
        log.info(dateUtil.formatLocalDateTimetoDatabaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok(cartoonService.listAll());//new ResponseEntity<>(cartoonService.listAll(), HttpStatus.OK);
    }

    @GetMapping(path="{id}")
    public ResponseEntity<Cartoon> findById(@PathVariable long id) {
        log.info(dateUtil.formatLocalDateTimetoDatabaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok(cartoonService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Cartoon> save(@RequestBody Cartoon cartoon) {
        log.info(dateUtil.formatLocalDateTimetoDatabaseStyle(LocalDateTime.now()));
        return new ResponseEntity<>(cartoonService.save(cartoon), HttpStatus.CREATED);
    }
}
