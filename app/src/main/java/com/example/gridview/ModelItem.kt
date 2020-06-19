package com.example.gridview

data class Model (
    var id : Int,
    var name : String,
    var image : Int,
    var info : String,
    var rate : Int
)

object Supplier {
    var data = arrayListOf<Model>(
        Model(
            1,
            "Nayeon",
            R.drawable.nayeon,
            "Im Na-yeon (sinh ngày 22 tháng 9 năm 1995) hay còn được viết là Nayeon là nữ ca sĩ người Hàn Quốc",
            5
        ), Model(
            2,
            "Jeongyeon",
            R.drawable.jeongyeon,
            "Yoo Jeongyeon, thường được biết đến với nghệ danh Jeongyeon, là một nữ ca sĩ người Hàn Quốc.",
            5
        ), Model(
            3,
            "Momo",
            R.drawable.momo,
            "Hirai Momo là một nữ ca sĩ thần tượng người Nhật Bản, thành viên nhóm nhạc Twice",
            5
        ), Model(
            4,
            "Sana",
            R.drawable.sana,
            "Được biết đến với nghệ danh Sana (Hangul: 사나), là ca sĩ thần tượng người Nhật Bản",
            5
        ),Model(
            5,
            "Jihyo",
            R.drawable.jihyo,
            "Là một nữ ca sĩ người Hàn Quốc, trưởng nhóm và giọng ca chính của nhóm nhạc Twice do công ty JYP",
            5
        ),  Model(
            6,
            "Mina",
            R.drawable.mina,
            "Là một nữ ca sĩ người Nhật Bản, thành viên nhóm nhạc Twice ",
            5
        ),
        Model(
            7,
            "Da-hyun",
            R.drawable.dahyun,
            "Là nữ ca sĩ thần tượng người Hàn Quốc, thành viên nhóm nhạc nữ Twice thông qua chương trình truyền hình thực tế Sixteen",
            5
        ),Model(
            8,
            "Chaeyoung",
            R.drawable.sana,
            "Là nữ ca sĩ thần tượng, rapper người Hàn Quốc, thành viên nhóm nhạc Twice",
            5
        ),
        Model(
            9,
            "Tzuyu",
            R.drawable.tzuyu,
            "Là nữ ca sĩ người Đài Loan, thành viên của nhóm nhạc nữ Twice do công ty JYP Entertainment quản lý.",
            5
        )
    )
}