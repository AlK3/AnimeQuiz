package aik3.game.animequiz

class QuizData {
    private val titles = arrayOf(
        Title(
            0,
            R.drawable.mohs,
            "Меланхолия Харухи Судзумии",
            "android.resource://aik3.game.animequiz/raw/mohs",
            "android.resource://aik3.game.animequiz/raw/mohs_e",
            "Главная героиня говорила: \"Меня не интересуют обычные люди. Если у вас есть пришельцы, существа из будущего, суперлюди, приходите ко мне. Это все!!\""
        ),
        Title(
            1,
            R.drawable.gto,
            "Крутой учитель Онидзука",
            "android.resource://aik3.game.animequiz/raw/gto",
            "android.resource://aik3.game.animequiz/raw/gto_e",
            "«22 года, холост» - так главный герой сам любит представляться. Настоящий ужас на двух колесах, решает переквалифицироваться в школьного учителя."
        ),
        Title(
            2,
            R.drawable.cb,
            "Ковбой Бибоп",
            "android.resource://aik3.game.animequiz/raw/cowboy",
            "android.resource://aik3.game.animequiz/raw/cowboy_e",
            "Человечество было вынуждено колонизировать Солнечную систему, ведь после техногенной катастрофы на Земле Луна была разрушена. Учёным удалось создать гиперпространственные врата."
        ),
        Title(
            3,
            R.drawable.cg,
            "Перекрестная игра",
            "android.resource://aik3.game.animequiz/raw/cg",
            "android.resource://aik3.game.animequiz/raw/cg_e",
            "Главный герой — сын владельца спортивного магазина — часто доставляет товары семье Цукисима. Их семьи очень близки, но приходит беда. Обеим семьям предстоит пережить страшное горе и продолжить двигаться дальше. И лишь время покажет, сумеют ли сблизиться главные герои, имеющие общее увлечение."
        ),
        Title(
            4,
            R.drawable.wcaay,
            "Волчьи дети Амэ и Юки",
            "android.resource://aik3.game.animequiz/raw/wcaay_e",
            "android.resource://aik3.game.animequiz/raw/wcaay_e",
            "Рассказывает о жизни маленькой, но очень необычной семьи, которой предстоит пройти через множество трудностей, чтобы сохранить свой секрет от посторонних."
        ),
        Title(
            5,
            R.drawable.pp,
            "Психо-Пасс",
            "android.resource://aik3.game.animequiz/raw/pp",
            "android.resource://aik3.game.animequiz/raw/pp_e",
            "В Будущем, стало возможным измерять эмоции человека. Эта история об отряде криминалистов, называющихся \"Исполнителями\" и \"Наблюдателями\", которые поддерживают порядок в довольно хрупком мире."
        ),
        Title(
            6,
            R.drawable.nhk,
            "Добро пожаловать в NHK",
            "android.resource://aik3.game.animequiz/raw/nhk",
            "android.resource://aik3.game.animequiz/raw/nhk_e",
            "Парень, у которого нет ни работы, ни друзей, ни каких-либо иных увлечений кроме просмотра аниме и телевизора. Он уверен, что существует великий заговор, который превращает людей в таких, как он. И виной тому одна корпорация."
        ),
        Title(
            7,
            R.drawable.wolf,
            "Волчица и пряности",
            "android.resource://aik3.game.animequiz/raw/wolf",
            "android.resource://aik3.game.animequiz/raw/wolf_e",
            "Это аниме пропитано духом средневековья, хотя здесь вы не увидите масштабных баталий и осад замков. Это аниме другая сторона того времени: аграрный вопрос и экономика, хитрости ведения торговли - вот с чем сталкиваются герои."
        ),
        Title(
            8,
            R.drawable.asv,
            "Форма голоса",
            "android.resource://aik3.game.animequiz/raw/asv",
            "android.resource://aik3.game.animequiz/raw/asv_e",
            "Сюжет данного аниме расскажет историю о мальчике и девочки. У девочки с детства были проблемы со слухом, и ей пришлось из-за этого много страдать. "
        ),
        Title(
            9,
            R.drawable.dn,
            "Тетрадь смерти",
            "android.resource://aik3.game.animequiz/raw/dn",
            "android.resource://aik3.game.animequiz/raw/dn_e",
            " А что случится, если тетрадь бога окажется в руках человека? Ответ очевиден: он возомнит себя богом."
        ),
        Title(
            10,
            R.drawable.hing,
            "Хеллсинг: Война с нечистью",
            "android.resource://aik3.game.animequiz/raw/hing",
            "android.resource://aik3.game.animequiz/raw/hing_e",
            "В мире всегда существовали ужасные существа, и пришло время, когда враги сумели обрести неимоверное могущество. Всё чаще на территории Англии начали появляться кровожадные вампиры."
        ),
        Title(
            11,
            R.drawable.hh,
            "Хантер х Хантер",
            "android.resource://aik3.game.animequiz/raw/hh",
            "android.resource://aik3.game.animequiz/raw/hh_e",
            "Многие авантюристы пускаются во все тяжкие в погоне за мечтой стать прославленным Охотником."
        ),
        Title(
            12,
            R.drawable.kon,
            "К-он!",
            "android.resource://aik3.game.animequiz/raw/kon",
            "android.resource://aik3.game.animequiz/raw/kon_e",
            "Главная героиня, начинающая гитаристка, спасая школьный музыкальный клуб от закрытия, она собирает музыкальный коллектив."
        ),
        Title(
            13,
            R.drawable.vs,
            "Сага о Винланде",
            "android.resource://aik3.game.animequiz/raw/vs",
            "android.resource://aik3.game.animequiz/raw/vs_e",
            "Завоеватели пришли на новые земли, чтобы не только разграбить их, но и вырезать всё население. Вот только главного героя он оставил в живых, а его отца подло убил. Мальчишка пообещал отомстить ему."
        ),
        Title(
            14,
            R.drawable.ms,
            "Мастер Муши",
            "android.resource://aik3.game.animequiz/raw/ms",
            "android.resource://aik3.game.animequiz/raw/ms_e",
            "Старейшины полагают, что вне земного шара есть организмы, отличающиеся от известных нам существ. Страшась тварей, преследующих человечество с древних времен, люди именуют их муши."
        ),
        Title(
            15,
            R.drawable.ve,
            "Вайолет Эвергарден",
            "android.resource://aik3.game.animequiz/raw/ve",
            "android.resource://aik3.game.animequiz/raw/ve_e",
            "Главная героиня продолжает помогать другим людям писать письма, выражая все чувства клиентов на бумаге. Однако она всё никак не может забыть о майоре Гилберте Бугенвиллее, который однажды дал ей возможность понять, что же значит «Я люблю тебя» и шанс начать жизнь с чистого листа."
        ),
        Title(
            16,
            R.drawable.op,
            "Ванпанчмен",
            "android.resource://aik3.game.animequiz/raw/op",
            "android.resource://aik3.game.animequiz/raw/op_e",
            "Каково живётся самому сильному человеку в мире?"
        ),
        Title(
            17,
            R.drawable.sc,
            "Самурай Чамплу",
            "android.resource://aik3.game.animequiz/raw/sc",
            "android.resource://aik3.game.animequiz/raw/sc_e",
            "Период Эдо, кодекс чести, катана - на ум сразу приходит слово «самурай», вот только главные герои далеки от самурайского идеала. Они - прекрасные бойцы с прескверными характерами, преследуемые демонами прошлого и волею судьбы оказавшиеся друг у друга на пути."
        ),
        Title(
            18,
            R.drawable.codeg,
            "Код Гиас",
            "android.resource://aik3.game.animequiz/raw/codeg",
            "android.resource://aik3.game.animequiz/raw/codeg_e",
            "Главный герой встречает не совсем обычную девушку, которая представляется С.С., она предлагает ему дар - способность подчинять волю других людей."
        ),
        Title(
            19,
            R.drawable.tg,
            "Токийский Гуль",
            "android.resource://aik3.game.animequiz/raw/tg",
            "android.resource://aik3.game.animequiz/raw/tg_e",
            "В этом мире параллельно с людьми существует раса созданий, стоящих выше людей в пищевой цепи, то есть людоедов."
        ),
        Title(
            20,
            R.drawable.bs,
            "Садистская смесь ",
            "android.resource://aik3.game.animequiz/raw/bs",
            "android.resource://aik3.game.animequiz/raw/bs_e",
            "Девочка устраивается на работу в кафе, в котором официантки должны играть разные роли такие как роль цундэрэ или роль младшей сестрички. И героине суждено сыграть роль садистки."
        ),
        Title(
            21,
            R.drawable.tmk,
            "Не моя вина, что я не популярна!",
            "android.resource://aik3.game.animequiz/raw/tmk",
            "android.resource://aik3.game.animequiz/raw/tmk_e",
            "Героиня долгое время играет в отомэ-игры и в виртуальном мире у неё большое количество поклонников, наждая попытка познакомиться с парнем ИРЛ заканчивается провалом."
        ),
        Title(
            22,
            R.drawable.tgr,
            "Некий научный Рейлган",
            "android.resource://aik3.game.animequiz/raw/tgr",
            "android.resource://aik3.game.animequiz/raw/tgr_e",
            "Рассказ о повседневной жизни эсперов в Академия-Сити."
        ),
        Title(
            23,
            R.drawable.sg,
            "Врата; Штейна",
            "android.resource://aik3.game.animequiz/raw/sg",
            "android.resource://aik3.game.animequiz/raw/sg_e",
            "Время - это не игрушка. Японский студент открывает способ перемещения сознания во времени и попадает в замкнутую череду событий временной петли."
        ),
        Title(
            24,
            R.drawable.ch,
            "Хаос; Вершина",
            "android.resource://aik3.game.animequiz/raw/ch",
            "android.resource://aik3.game.animequiz/raw/ch_e",
            "Главный герой является отаку и геймером, и уже давно его не интересует реальность, ему проще находиться в параллельном мире."
        ),
        Title(
            25,
            R.drawable.wl,
            "Женская логика ",
            "android.resource://aik3.game.animequiz/raw/wl",
            "android.resource://aik3.game.animequiz/raw/wl_e",
            "Рассказ о обычных беседах на Разные темы 5 девушек за кулисами японского театра Ракуго. И к чему в их вопросах и дилеммах и куда приводит их логика."
        )
    )

    fun getTitles(): Array<Title> {
        return titles
    }

    fun getByIndex(index: Int): Title {
        return titles[index]
    }

    class Title(
        val id: Int,
        val image: Int,
        val title: String,
        val opening: String,
        val ending: String,
        val description: String
    )
}