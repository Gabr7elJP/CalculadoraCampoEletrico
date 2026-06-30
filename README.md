## 🧪 Exercício base

O sistema foi desenvolvido a partir do seguinte problema de Física:

> Na Fig. 22.44, oito partículas estão no perímetro de um quadrado de lado
d = 2,0 cm. As cargas das partículas são q1 = +3e, q2 = +e, q3 =- 5e, q4 =- 2e,
q5 =+3e, q6 = +e, q7 =- 5e e q8 = +e. Na notação dos vetores unitários, qual é
o campo elétrico produzido pelas partículas no centro do quadrado?  .

> 📌 <img src="images/diagrama.png">
---
## ⚙️ Resolução

Durante a resolução do exercício, observa-se que:

- As cargas q1 e q5, q3 e q7, e q2 e q6 são removidas porque seus campos elétricos possuem mesma intensidade, porém sentidos opostos.
- Sobrando apenas q4 e q8.
- q4 atrai a carga de teste para si, fazendo o campo elétrico apontar para a direita.
- q8 repele a carga de teste na direção de q4, fazendo com que seu campo elétrico também aponte para a direita.


Para calcular o campo elétrico produzido por cada carga, utiliza-se a expressão:

E = kq/d²

Como os campos elétricos produzidos por q4 e q8 apontam para a mesma direção e para o mesmo sentido, eles podem ser somados.

Assim, o campo elétrico resultante é dado por:

E = E4 + E8

Substituindo os valores das cargas:

q4 = 2e

q8 = e

temos:

E = k(2e) / d² + k(e) / d²

Esse valor representa o campo elétrico resultante produzido pelas cargas q4 e q8.

Como o denominador é o mesmo, somam-se os numeradores, obtendo:

E = 3ke/d²

Por fim, substitui-se a distância fornecida no exercício, sendo d = 2,0 cm, ou 2,0 × 10⁻² m.

**E ≈ 1,08 × 10⁻⁵**

---
## 📥 Inputs

- **Carga q4:** valor da carga elétrica q4.
- **Carga q8:** valor da carga elétrica q8.
- **Distância (d):** distância entre as cargas e o ponto onde será calculado o campo elétrico.
---
## 📤 Outputs

- **Campo elétrico produzido por q4;**
- **Campo elétrico produzido por q8;**
- **Campo resultante**
---

## ⚠️ Tratamento de erros

- **As cargas não podem ser iguais a zero.**

Exemplo: q4 = 0 ou q8 = 0

- **A distância deve ser maior que zero.**

Exemplo: d = 0

- **Os valores digitados devem ser numéricos.**

Exemplo: q4 = aaa
