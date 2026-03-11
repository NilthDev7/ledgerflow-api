package ledgerFlow.service;

import ledgerFlow.entity.Produto;
import ledgerFlow.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> getAll(){
        return produtoRepository.findAll();
    }

    public Optional<Produto> getById(Long id){
        return produtoRepository.findById(id);
    }

}
