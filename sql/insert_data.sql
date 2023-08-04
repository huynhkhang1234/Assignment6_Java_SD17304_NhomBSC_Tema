USE Website_Lamborghini
GO
INSERT INTO [dbo].[roles]
           ([roles]
           ,[actions])
     VALUES
           ('admin','admin'),('user','views'),('staff_edit','edit')
GO
-----------------------------------------------------------------------------
INSERT INTO dbo.users
(user_names
           ,first_names
           ,last_names
           ,email
           ,pass_words
           ,images
           ,phones
           ,address
           ,roles_id
           ,create_date
           ,update_date
,is_active)
     VALUES
	 (N'huynhkhang',N'Khang',N'Huỳnh','khanghbpc04012@fpt.edu.vn','123',N'10.png','0123456789','Cà Mau',1,'2023-5-27','2023-5-28',1)
	 ,(N'nguyenphi',N'Phi',N'Nguyễn','phinvhpc04124@fpt.edu.vn','123',N'kazuha.jpg','0123456789',N'Trà Vinh',1,'2023-5-27','2023-5-28',1)           
	 ,(N'trantham',N'Thắm',N'Trần','thamtthpc03916@fpt.edu.vn','123',N'7.png','0123456789',N'Hậu Giang',2,'2023-5-27','2023-5-28',1)           
	 ,(N'phamvan',N'Vương',N'Phạm','vuongpvpc04104@fpt.edu.vn','123',N'8.png','0123456789',N'Phú Quốc',2,'2023-5-27','2023-5-28',1)           
	 ,(N'nguyenhong',N'Ngoan',N'Nguyễn','ngoannpc04172@fpt.edu.vn','123',N'9.png','0123456789',N'Cần Thơ',2,'2023-5-27','2023-5-28',1)           
GO
-----------------------------------------------------------------------------------------
INSERT INTO [dbo].[orders]
           ([notes]
           ,[status]
           ,[sum_money]
           ,[users_id]
           ,[money_received])
     VALUES
          (N'sản phẩm tốt',N'Đang vẩn chuyển',39600000,1,39600000)
		  ,(N'sản phẩm tốt',N'Đã hoàn thành',34300000,2,34300000)
		  ,(N'sản phẩm tốt',N'Đang chờ sử lý',22500000,3,22500000)		
		  ,(N'sản phẩm tốt',N'Đã hoàn thành',44800000,5,44800000)
		  ,(N'sản phẩm tốt',N'Đã hoàn thành',34300000,4,34300000)
		  ,(N'sản phẩm tốt',N'Đang vẩn chuyển',29400000,1,29400000)
		  ,(N'sản phẩm tốt',N'Đã hoàn thành',41400000,4,41400000)
		  ,(N'sản phẩm tốt',N'Đang chờ sử lý',34300000,3,34300000)		
		  ,(N'sản phẩm tốt',N'Đã hoàn thành',13800000,5,13800000)
		  ,(N'sản phẩm tốt',N'Đã hoàn thành',15600000,2,15600000)	
		  go
------------------

INSERT INTO [dbo].[categories]
           ([names])
     VALUES
           (N'Màn Hình Android Ô Tô')
		   ,(N'Android Box')
		   ,(N'Đèn Ô Tô')
		   ,(N'Phim Cách Nhiệt')
		   ,(N'Camera')
		   ,(N'Âm Thanh Ô Tô')
		   ,(N'Thảm')
		   ,(N'Tiện ích xe')
		   ,(N'Phụ kiện Ô tô')
GO

------------------------------------------------------------------------------------
INSERT INTO [dbo].[suppliers]
           ([user_names]
           ,[emails]
           ,[images]
           ,[phones]
           ,[address]
           ,[status]
           ,[create_date]
           ,[update_date]
           ,[is_active])
     VALUES
          
		  (N'Phạm Văn Vương',N'Vuongpvpc04000@fpt.edu.vn',N'Hình ảnh','0123456789',N'Phú Quốc',1,'2023-05-27','2023-05-28',1),
		  (N'Trần Thị Hồng Thắm',N'Thamthpc04000@fpt.edu.vn',N'Hình ảnh','0123456789',N'Hậu Giang',1,'2023-05-27','2023-05-28',1),
		  (N'Nguyễn Hồng Ngoan',N'Ngoannhpc04172@fpt.edu.vn',N'Hình ảnh','0123456789',N'Cần Thơ',1,'2023-05-27','2023-05-28',1)
GO
------------------------------------------------------------------------------
INSERT INTO [dbo].[discounts]
           ([titles]
           ,[descriptions]
           ,[price_discounts]
           ,[start_day]
           ,[end_day])
     VALUES
           (N'Đèn xe ô tô',N'Đèn xe tốt',20,'2023-05-27','2023-05-28'),
		   (N'Sạc không dây thông minh xe ô tô Smart Sensor R1 – Bạc',N'Sạc chính hãng',40,'2023-05-27','2023-05-28'),
		   (N'Màn Hình Ô Tô Android Zestech S100J – Phiên Bản Tiết Kiệm',N'Màn hình chính hãng',0,'2023-05-27','2023-05-28')
GO
-----------------------------------------------------------------------------------
INSERT INTO [dbo].[products]
           ([titles]
           ,[price]
           ,[images]
           ,[description]
           ,[categories_id]
           ,[suppliers_id]
           ,[original_price])
VALUES
        (N'Màn hình Android ô tô thông minh GOTECH GT8 MAX - Best Seller 2022', 12900000, N'manhinh1.jpg', N'CPU: 8 nhân – 1.8GHz', 1, 1, 6000000)
	   ,(N'Màn hình NaviPlay N600 chính hãng – Thiết bị giải trí giá rẻ cho ô tô', 6900000, N'manhinh2.jpg', N'CPU: 8 nhân – 1.8GHz', 1, 2, 6000000)
	   ,(N'Màn hình android OledPro A5', 7800000, N'manhinh3.jpg', N'CPU: 8 nhân – 1.8GHz', 1, 2, 6000000)
	   ,(N'Android Box Safeview SA-6125', 6900000, N'manhinh4.jpg', N'CPU: 8 nhân – 1.8GHz', 2, 1, 6000000)
	   ,(N'Android Box Zestech DX300', 9500000, N'manhinh5.jpg', N'CPU: 8 nhân – 1.8GHz', 2, 2, 6000000)
	   ,(N'Carplay Box GB8 - Android Box Ô Tô Gotech', 8900000, N'manhinh6.jpg', N'CPU: 8 nhân – 1.8GHz', 2, 1, 6000000)
	   ,(N'Đèn Bi Led X-Light V20 New 2022', 7500000, N'manhinh7.jpg', N'Công suất: Cos 55W/Pha 70W', 3, 2, 6000000)
	   ,(N'Bi Gầm Led Aozoom Eagle Light', 5050000, N'manhinh8.png', N'Công suất: Cos 32W/Pha 38W', 3, 1, 6000000)
	   ,(N'Đèn Bi Laser TiTan Platinum Plus 9+3', 16900000, N'manhinh9.jpg', N'Công suất: Cos 80W/Pha 90W', 3, 2, 6000000)
	   ,(N'Camera 360 ô tô GOTECH GP6 Mới nhất – Panda Auto', 12500000, N'manhinh10.jpg', N'Mắt Camera: Sony A225', 5, 1, 6000000)
	   ,(N'Camera 360 OledPro AHD', 10500000, N'manhinh11.png', N'Mắt Camera: Sony A225', 5, 2, 6000000)
	   ,(N'Camera 360 Safeview LD980H', 18900000, N'manhinh12.jpg', N'Mắt Camera: Sony', 5, 1, 6000000)
	   ,(N'Hệ thống âm thanh ô tô DB DRIVE ES7 6C', 4650000, N'mh13.jpg', N'Công Suất Max: 225W', 6, 1, 6000000)
	   ,(N'Loa cánh ô tô HELIX F 62C', 18000000, N'mh14.png', N'Công suất tối đa: 120W', 6, 2, 6000000)
	   ,(N'Loa cánh DB DRIVE ES1 60', 1200000, N'mh15.jpg', N'Công suất đầu vào tối đa: 110W.', 6, 3, 6000000)
	   ,(N'Cảm biến áp suất lốp GOTECH GL509 – Màn hình hiển thị rời', 2700000, N'mh16.png', N'Hiển thị đồng thời áp suất và nhiệt độ 4 lốp trên 1 màn hình', 8, 1, 6000000)
	   ,(N'Cảm biến áp suất lốp GOTECH GL603 – Van trong an toàn', 2900000, N'mh17.png', N'Hiển thị đồng thời áp suất và nhiệt độ 4 lốp trên 1 màn hình', 8, 2, 6000000)
	   ,(N'Cảm biến áp suất lốp ô tô GOTECH GL509N – Màn hình rời cao cấp', 2700000, N'mh18.jpg', N'Hiển thị đồng thời áp suất và nhiệt độ 4 lốp trên 1 màn hình', 8, 3, 6000000)
	   ,(N'Bọc Vô Lăng Ô Tô Da Cao Cấp SPARCO Italia', 349000, N'volang.jpg', N'Phù hợp với hầu hết các loại xe 4 – 7 chỗ', 9, 1, 6000000)
	   ,(N'Bơm Lốp Ô Tô Tự Ngắt Steelmate P05', 700000, N'mh19.jpg', N'Điện áp vào: 12V', 9, 2, 6000000)
	   ,(N'Sáp Thơm Ô Tô AREON – Khử Mùi Xe Hơi Cao Cấp', 240000, N'mh20.jpg', N' Đảm bảo tiêu chuẩn an toàn của EU', 9, 3, 6000000)
	   ,(N'Thảm lót sàn ô tô 5D, 6D xe Vinfast Fadil', 1200000, N'thamlot1.png', N'Thảm được thiết kế vừa khít sàn xe, chống bụi bẩn, chống xô lệch', 7, 1, 6000000)
	   ,(N'Thảm lót sàn ô tô 5D, 6D xe Lexus NX200T, NX300', 1200000, N'thamlot1.jpg', N'hảm được thiết kế vừa khít sàn xe, chống bụi bẩn.', 7, 2, 6000000)
	   ,(N'Loa SUB siêu trầm Blaupunkt XLF 180A – Panda Auto', 2400000, N'mh21.jpg', N'Công suất: (RMS): 180W', 6, 3, 6000000)
GO
--------------------------------------------------------
INSERT INTO [dbo].[galleries]
           ([products_id]
           ,[images])
     VALUES
           (1,N'Hình ảnh 1'),
		   (1,N'Hình ảnh 2'),
		   (1,N'Hình ảnh 3'),
		   (1,N'Hình ảnh 4'),
		   (2,N'Hình ảnh 2.1'),
		   (2,N'Hình ảnh 2.2'),
		   (2,N'Hình ảnh 2.3'),
		   (2,N'Hình ảnh 2.4')
GO
--------------------------------------------------------------
INSERT INTO [dbo].[order_details]
           ([orders_id]
           ,[products_id]
           ,[price]
           ,[quanlity]
           ,[sum_money])
     VALUES
          (1,1,12900000,2,25800000),
		   (1,2,6900000,2,13800000),
		    (2,3,7800000,2,15600000),
			(2,2,6900000,3,18700000),
			(3,2,6900000,1,6900000),
		   (3,3,7800000,2,15600000),
		   (4,1,12900000,2,25800000),
		   (4,5,9500000,2,19000000),
		    (5,3,7800000,2,15600000),
			(5,2,6900000,3,18700000),
			(6,2,6900000,2,13800000),
		   (6,3,7800000,2,15600000),
		   (7,1,12900000,2,25800000),
		   (7,3,7800000,2,15600000),
		    (8,3,7800000,2,15600000),
			(8,2,6900000,3,18700000),
			(9,2,6900000,2,13800000),
		   (10,3,7800000,2,15600000)
GO
---------------------------------------
INSERT INTO [dbo].[likes]
           ([users_id]
           ,[products_id]
           ,[is_likes])
     VALUES
            (1,1,1)
		   ,(1,2,1)
		   ,(1,3,1)
		   ,(2,4,1)
		   ,(2,5,1)
		   ,(2,6,1)
		   ,(3,3,1)
		   ,(3,4,1)
		   ,(3,6,1)
		   ,(4,7,1)
		   ,(4,1,1)
		   ,(4,2,1)
		   ,(5,3,1)
		   ,(5,2,1)
		   ,(5,1,1)
		   go
---------------------------------------------------------
INSERT INTO [dbo].[products_reviews]
           ([stars_number]
           ,[content]
           ,[users_id]
           ,[orders_id])
     VALUES
           (4,N'Sản phẩm hợp giá tiền, dễ sử dụng cực kì luôn á nha. Tuy nhiên, mình lỡ mua size k vừa, hơi nhỏ quá.',1,1),
		   (4,N'Sản phẩm hợp giá tiền, dễ sử dụng cực kì luôn á nha',1,2),
		   (5,N'Sản phẩm hợp giá tiền, dễ sử dụng cực kì luôn á nha',2,2),
		   (5,N'Sản phẩm hợp giá tiền, dễ sử dụng cực kì luôn á nha',2,1)
GO
-------------------------------------------------------------
INSERT INTO [dbo].[categories_news]
           ([titles])
     VALUES
           (N'Tin tức đèn xe'),
		   (N'Tin tức dây sạc thông minh')
GO
------------------------------------------------------------------
INSERT INTO [dbo].[news]
           ([titles]
           ,[contents]
           ,[video_href]
           ,[images]
           ,[create_date]
           ,[update_date]
           ,[is_active]
           ,[categories_id]
           ,[users_id])
     VALUES
           (N'Sạc không dây thông minh xe ô tô Smart Sensor R1 – Bạc',
		   N'Sau khi Apple và Samsung trang bị tính năng sạc không dây cho những chiếc điện thoại đầu bảng của họ như iPhone X, iPhone 8/8+ hay Note 8, Galaxy S8/S8+,… thì lập tức các phụ kiện sạc không dây đã trở nên “hot” hơn trên thị trường phụ kiện điện thoại.'
		   ,N'Video ',N'Hình ảnh','2023-05-27','2023-05-28',1,1,1),
		   (N'Đèn xe thông minh Bạc',
		   N'Tiếp nối sự thành công rực rỡ của sản phẩm Bi led oto X-light V20, thương hiệu X-light đã tiếp tục cho ra mắt bản cập nhật 2022 với hoàn thiện cao hơn. Một trong những ưu điểm nổi bật nhất của sản phẩm '
		   ,N'Video ',N'Hình ảnh','2023-05-27','2023-05-28',1,2,2),
		   (N'Thi tốt nghiệp THPT 2023: Lên phương án cho những tình huống đặc biệt',
		   N'<h2 class="detail-sapo" style="-webkit-font-smoothing: antialiased; text-rendering: geometricprecision; box-sizing: border-box; margin: 0px; border-top: 1px solid #ebebeb; font-size: 17px; line-height: 26px; color: #292929; padding: 24px 0px; font-family: Merriweather; background-color: #ffffff;" data-role="sapo">Bộ GD-ĐT đ&atilde; tổ chức nhiều đo&agrave;n c&ocirc;ng t&aacute;c đến c&aacute;c địa phương tr&ecirc;n cả nước kiểm tra c&ocirc;ng t&aacute;c chuẩn bị cho kỳ thi tốt nghiệp THPT năm 2023 sắp tới.</h2>
<div id="zone-k911czvz" style="-webkit-font-smoothing: antialiased; text-rendering: geometricprecision; box-sizing: border-box; color: #333333; font-family: Merriweather; font-size: 14px; background-color: #ffffff;">
<div id="share-k911czwh" style="-webkit-font-smoothing: antialiased; text-rendering: geometricprecision; box-sizing: border-box;">
<div id="placement-kalznos4" style="-webkit-font-smoothing: antialiased; text-rendering: geometricprecision; box-sizing: border-box;">
<div id="banner-k911czvz-kalznosg" style="-webkit-font-smoothing: antialiased; text-rendering: geometricprecision; box-sizing: border-box; min-height: 0px; min-width: 0px;">
<div id="slot-1-k911czvz-kalznosg" style="-webkit-font-smoothing: antialiased; text-rendering: geometricprecision; box-sizing: border-box;">
<div id="ssppagebid_6314" style="-webkit-font-smoothing: antialiased; text-rendering: geometricprecision; box-sizing: border-box;"></div>
</div>
</div>
</div>
</div>
</div>
<div class="detail-cmain" style="-webkit-font-smoothing: antialiased; text-rendering: geometricprecision; box-sizing: border-box; margin-bottom: 24px; color: #333333; font-family: Merriweather; font-size: 14px; background-color: #ffffff;">
<div class="detail-content afcbc-body" style="-webkit-font-smoothing: antialiased; text-rendering: geometricprecision; box-sizing: border-box; font-family: Inter; font-size: 17px; color: #292929; max-width: 100%; line-height: 26px !important;" data-role="content" data-io-article-url="https://thanhnien.vn/thi-tot-nghiep-thpt-2023-len-phuong-an-cho-nhung-tinh-huong-dac-biet-18523061400293869.htm">
<div style="-webkit-font-smoothing: antialiased; text-rendering: geometricprecision; box-sizing: border-box; height: 0px;" data-check-position="body_start">&nbsp;</div>
<p style="-webkit-font-smoothing: antialiased; text-rendering: geometricprecision; box-sizing: border-box; margin: 0.5em 0px 24px;">Ng&agrave;y 13.6, Bộ trưởng Bộ GD-ĐT Nguyễn Kim Sơn đ&atilde; dẫn đầu đo&agrave;n c&ocirc;ng t&aacute;c của Bộ đi kiểm tra, thị s&aacute;t c&ocirc;ng t&aacute;c chuẩn bị tổ chức cho kỳ thi tốt nghiệp THPT tại TP.HCM</p>
</div>
</div>
<div class="ddict_btn" style="top: 168px; left: 1182.4px;"><img src="chrome-extension://bpggmmljdiliancllaapiggllnkbjocb/logo/48.png" /></div> '
		   ,N'Video ',N'Hình ảnh','2023-05-27','2023-05-28',1,2,2)
GO
-----------------------------------------------------















