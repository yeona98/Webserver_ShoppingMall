const itemsBox = document.getElementById("items-box")

async function loadData() {
    const response = await fetch("http://localhost:8080/api/items",
        {
            headers: {
                "Content-Type": "application/json"
            }
        });
    const items = await response.json();

    let output = ""
    for (const item of await items) {
        console.log(item);
        const {id, name, price, stockQuantity, category, description, picUrl} = item;

        const viewUrl = "item/" + id;
        const editUrl = "update-item/" + id;
        output +=
            `
            <div class="col-md-4">
                    <div class="card mb-4 shadow-sm">
                    <svg>
                    <image xlink:href=${picUrl} width="100" height="100" />
                    </svg>
                        <title>${name}</title><rect width="100%" height="100%" fill="#55595c"/><text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text></svg>
                        <div class="card-body">
                            <p class="card-text"></p>
                            <div class="d-flex justify-content-between align-items-center">
                                <div class="btn-group">
                                    <button onclick="location.href = '${viewUrl}'" type="button" class="btn btn-sm btn-outline-secondary">View</button>
                                    <button onclick="location.href = '${editUrl}'" type="button" class="btn btn-sm btn-outline-secondary">Edit</button>
                                </div>
                                <small class="text-muted">9 mins</small>
                            </div>
                        </div>
                    </div>
                </div>
    `
    }
    console.log('output: ',output);
    itemsBox.innerHTML = output;
}


loadData();