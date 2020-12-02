package pt.hermanoportes.springbootessentials.repository;

import pt.hermanoportes.springbootessentials.model.Cartoon;

import java.util.List;

public interface CartoonRepository {

    public List<Cartoon> listAll();
}
