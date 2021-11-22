SELECT p.id AS id_produto, p.nome, e.quantidade FROM estoque as e
JOIN produto AS p ON e.produto_id = p.id order by p.id asc;

select rp.valor_pedido from registra_pedido AS rp
JOIN registra_pedido_produto AS rpp ON  rp.id = rpp.id_pedido
where id_cliente = 3;


select * from estoque
where produto_id = 1;