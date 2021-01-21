async function getCarts() {
    const response = await fetch("http://localhost:8080/carts")
    const carts = response.json();

    console.log(carts);
}

getCarts();