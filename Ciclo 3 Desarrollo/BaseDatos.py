from sqlalchemy import create_engine
engine = create_engine('sqlite:///ProyectosConstruccion.db')

print(engine)

with engine.connect() as con:
    rs = con.execute('SELECT * FROM Compra')
    for row in rs:
        print(row)