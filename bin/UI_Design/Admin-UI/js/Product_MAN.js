// var data = []

// function add() {
//     var Ma = document.getElementById("ma").value
//     var TieuDe = document.getElementById("tieuDe").value
//     var GiamGia = document.getElementById("giamGia").value
//     var NgayBD = document.getElementById("ngayBD").value
//     var NgayKT = document.getElementById("ngayKT").value
//     var MoTa  = document.getElementById("moTa").value


//     var pro = {
//         id: Ma,
//         title: TieuDe,
//         price_discounts: GiamGia,
//         start_day: NgayBD,
//         end_day: NgayKT,
//         descriptions: MoTa
//     }
//     data.push(pro)
//     render()
// }

// function render() {
//     table = `<tr>
//             <th>Mã</th>
//             <th>Tiêu đề</th>
//             <th>Giảm giá</th>
//             <th>Ngày bắt đầu</th>
//             <th>Ngày kết thúc</th>
//             <th>Mô tả</th>
//         </tr>`

//     for(let i = 0; i<data.length; i++){
//         table += `<tr>
//             <td>${data[i].id}</td>
//             <td>${data[i].title}</td>
//             <td>${data[i].price_discounts}</td>
//             <td>${data[i].start_day}</td>
//             <td>${data[i].end_day}</td>
//             <td>${data[i].descriptions}</td>
//         </tr>`
//     }

//     document.getElementById("render").innerHTML = table
// }


var addProduct = document.querySelector("#add-product");
var modal = document.querySelector(".modal-body");
addProduct.onclick = function() {
    alert();
}