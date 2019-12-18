create trigger Refund on report
	after insert
as
	begin
		declare @GNo nchar(10),@num int,@Month nchar(10),@Day nchar(10),@rName nchar(11),@Counts int
		select @GNo = GNo from inserted
		select @num = num from inserted
		select @Day = Day from inserted
		select @Counts = counts from inserted,trains where inserted.GNo = trains.GNo
		set @rName = 'remaining'+@Day
		if @Day = '01'
			update Trains01
			set remaining01 = remaining01+@num
			where GNo=@GNo and remaining01+@num <= @Counts
		if @Day = '02'
			update Trains01
			set remaining02 = remaining02+@num
			where GNo=@GNo and remaining02+@num <= @Counts
		if @Day = '03'
			update Trains01
			set remaining03 = remaining03+@num
			where GNo=@GNo and remaining03+@num <= @Counts
		if @Day = '04'
			update Trains01
			set remaining04 = remaining04+@num
			where GNo=@GNo and remaining04+@num <= @Counts
		if @Day = '05'
			update Trains01
			set remaining05 = remaining05+@num
			where GNo=@GNo and remaining05+@num <= @Counts
		if @Day = '06'
			update Trains01
			set remaining06 = remaining06+@num
			where GNo=@GNo and remaining06+@num <= @Counts
		if @Day = '07'
			update Trains01
			set remaining07 = remaining07+@num
			where GNo=@GNo and remaining07+@num <= @Counts
		if @Day = '08'
			update Trains01
			set remaining08 = remaining08+@num
			where GNo=@GNo and remaining08+@num <= @Counts
		if @Day = '09'
			update Trains01
			set remaining09 = remaining09+@num
			where GNo=@GNo and remaining09+@num <= @Counts
		if @Day = '10'
			update Trains01
			set remaining10 = remaining10+@num
			where GNo=@GNo and remaining10+@num <= @Counts
		if @Day = '11'
			update Trains01
			set remaining11 = remaining11+@num
			where GNo=@GNo and remaining11+@num <= @Counts
		if @Day = '12'
			update Trains01
			set remaining12 = remaining12+@num
			where GNo=@GNo and remaining12+@num <= @Counts
		if @Day = '13'
			update Trains01
			set remaining13 = remaining13+@num
			where GNo=@GNo and remaining13+@num <= @Counts
		if @Day = '14'
			update Trains01
			set remaining14 = remaining14+@num
			where GNo=@GNo and remaining14+@num <= @Counts
		if @Day = '15'
			update Trains01
			set remaining15 = remaining15+@num
			where GNo=@GNo and remaining15+@num <= @Counts
		if @Day = '16'
			update Trains01
			set remaining16 = remaining16+@num
			where GNo=@GNo and remaining16+@num <= @Counts
		if @Day = '17'
			update Trains01
			set remaining17 = remaining17+@num
			where GNo=@GNo and remaining17+@num <= @Counts
		if @Day = '18'
			update Trains01
			set remaining18 = remaining18+@num
			where GNo=@GNo and remaining18+@num <= @Counts
		if @Day = '19'
			update Trains01
			set remaining19 = remaining19+@num
			where GNo=@GNo and remaining19+@num <= @Counts
		if @Day = '20'
			update Trains01
			set remaining20 = remaining20+@num
			where GNo=@GNo and remaining20+@num <= @Counts
		if @Day = '21'
			update Trains01
			set remaining21 = remaining21+@num
			where GNo=@GNo and remaining21+@num <= @Counts
		if @Day = '22'
			update Trains01
			set remaining22 = remaining22+@num
			where GNo=@GNo and remaining22+@num <= @Counts
		if @Day = '23'
			update Trains01
			set remaining23 = remaining23+@num
			where GNo=@GNo and remaining23+@num <= @Counts
		if @Day = '24'
			update Trains01
			set remaining24 = remaining24+@num
			where GNo=@GNo and remaining24+@num <= @Counts
		if @Day = '25'
			update Trains01
			set remaining25 = remaining25+@num
			where GNo=@GNo and remaining25+@num <= @Counts
		if @Day = '26'
			update Trains01
			set remaining26 = remaining26+@num
			where GNo=@GNo and remaining26+@num <= @Counts
		if @Day = '27'
			update Trains01
			set remaining27 = remaining27+@num
			where GNo=@GNo and remaining27+@num <= @Counts
		if @Day = '28'
			update Trains01
			set remaining28 = remaining28+@num
			where GNo=@GNo and remaining28+@num <= @Counts
		if @Day = '29'
			update Trains01
			set remaining29 = remaining29+@num
			where GNo=@GNo and remaining29+@num <= @Counts
		if @Day = '30'
			update Trains01
			set remaining30 = remaining30+@num
			where GNo=@GNo and remaining30+@num <= @Counts
		if @Day = '31'
			update Trains01
			set remaining31 = remaining31+@num
			where GNo=@GNo and remaining31+@num <= @Counts
	end