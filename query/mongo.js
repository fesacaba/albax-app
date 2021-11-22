db.registraPedido.find({
    "cliente._id":NumberLong(3),
    "idPedido": NumberLong(99),
    dataPedido: {
        $gte: ISODate("2019-12-01"),
        $lt: ISODate("2019-12-30")
    }
})