import '@/styles/WriteReceipt.css'
import '@/styles/MainPageButton.css'
import ReceiptCircle from './ReceiptCircle'

const ReceiptInput = () => {
    return (
        <>
        <div>
            <div className='flex flex-col items-center bg-[#EEE] w-[70vw] max-w-[330px] min-w-[300px]'>
                <div className='logo mb-3 mt-6'>AKGIMI</div>
                <form className='flex flex-col items-center'>
                    <input type="text" placeholder="끼밍템을 입력해주세요" />
                    <input type="number" placeholder="가격을 입력해주세요"/>
                    <input type="text" placeholder="장소를 입력해주세요" />
                    <input type="" className='h-[100px]' disabled/>
                    <input type="text" className='h-[100px]' placeholder='내용을 입력해주세요'/>
                    {/* 사진 첨부 form hidden */}
                    <input className="hidden" type="file" multiple accept="image/*"/>
                    <div className='flex mt-1 mb-8 pe-28'>
                        <p className='pe-4'>공개 여부</p>
                        <input type="checkbox" className="switch" />
                    </div>
                </form>
            </div>
            <div className='flex justify-center z-0 -mt-4'>
                <ReceiptCircle />
            </div>
            <div className='flex justify-center mt-2'>
                <button type="submit" className="button-common-small blue-btn">기록 남기기</button>
            </div>
          
        </div>
        
        </>
    )
}

export default ReceiptInput